package org.peng.datascience.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
/**
  * Created by Dad on 5/14/2017.
  */
object testBasicStat {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("ch1")
    conf.setMaster("local[*]")

    val sc = new SparkContext(conf)
    sc.textFile("")


  }
}
