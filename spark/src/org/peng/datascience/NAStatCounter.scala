package org.peng.datascience

import org.apache.spark.util.StatCounter

/**
  * Created by Dad on 5/20/2017.
  */
class NAStatCounter  extends Serializable {
  val stats = new StatCounter()
  var missing = 0

  def add(x : Double) : NAStatCounter ={
    if(x == Double.NaN){
      missing += 1
    }
    else{
      stats.merge(x)
    }
    this
  }

  def merge(other : NAStatCounter) : NAStatCounter= {
    stats.merge(other.stats)
    missing += other.missing
    this
  }

  override def toString = stats.toString() + " missing " + missing
  
}
