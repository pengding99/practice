package org.peng.datascience.test

import org.apache.spark.rdd.RDD
import java.lang.Double.isNaN
import org.apache.spark.{SparkConf, SparkContext}
import org.peng.datascience.{DataRow, ParseUtils}


object TestBasicStat {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
    conf.setAppName(this.getClass.getName)
    conf.setMaster("local[*]")

    val sc = new SparkContext(conf)
    val rawFile = sc.textFile("hdfs://localhost:19000/aas/linkage")
    val noHeader = rawFile.filter(!ParseUtils.isHeader(_, "id_1"))
    val parsedData = noHeader.map(ParseUtils.parseLine(_, ","))
    val tupleData = parsedData.map(row => {
        val rowData = row.data
        (rowData(0).toInt, rowData(1).toInt, rowData.slice(2, 11).map(x=> if(x == "?") Double.NaN else x.toDouble), rowData(11).toBoolean)
      }
    )
    tupleData.cache()
    tupleData.map( x => (x._4, 1)).reduceByKey((v1, v2) => v1+v2).collect().foreach(println(_))
    println(tupleData.map(x => x._3(0)).filter(isNaN(_)).stats())


  }

}
