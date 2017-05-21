package org.peng.datascience

/**
  * Created by Dad on 5/16/2017.
  */
object ParseUtils {

  def isHeader(line : String, header : String) : Boolean= {
    line.trim().contains(header);
  }

  def parseLine(line : String , separator : String) : DataRow[String] = {
      DataRow(line.split(separator))
  }


}
