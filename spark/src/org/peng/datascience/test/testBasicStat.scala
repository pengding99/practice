package org.peng.datascience.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.peng.datascience.ParseUtils


object TestBasicStat {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
    conf.setAppName(this.getClass.getName)
    conf.setMaster("local[*]")

    val sc = new SparkContext(conf)
    val rawFile = sc.textFile("")
    val noHeader = rawFile.filter(ParseUtils.isHeader(_, "id_1"))
    val parseData = noHeader.map(ParseUtils.parseLine(_, ","))

  }

}
