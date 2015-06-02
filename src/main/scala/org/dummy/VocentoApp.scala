package org.dummy

import java.util.regex.{Pattern, Matcher}

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import scala.util.matching.Regex

object VocentoApp extends App {
  //val logFile = "ppll_canalgrana.com_web.log"
  val logFile = "logs/*.log"
  val sc = new SparkContext("local", "Simple", "$SPARK_HOME"
    , List("target/spark-ejercicio-1.0.jar"))
  val file = sc.textFile(logFile)

  val logRDD = file.map(line => {

    //val regExpr= """(\S+) (\S+) (\S+) (\S+) (\S+) (\S+) (\S+) \[([^:]+):(\d+:\d+:\d+) ([^\]]+)\] \"(\S+) (.*?) (\S+)\" (\S+) (\S+) (\".*?\") (\".*?\") (\d) (\S+)""".r

      new Logs(line)

    }
  )

  val claveValorRDD = logRDD.map(x=>(x.getDominio(),1))

  val reducedRDD = claveValorRDD.reduceByKey((acum,nuevo) => (acum+nuevo))

  val mappedRDD = reducedRDD.map(x=>(x._1,x._2)).foreach(r=>println(r._1, r._2))



// Para cada uno que sume las medallas y que nos de el úlimo año
// [name,(gold,silver,bronze,año)] --> Es una tupla que contiene tuplas
//
//Hago un map

  /* val filasRDD = logRDD.map(x => (x.getBytes, 1))
   val reduceRDD = filasRDD.reduceByKey((y,z)=>(y + z))

   reduceRDD.map(x=>(x._1,x._2)).foreach(x=>  println(x._1 + ", " + x._2))
*/
  /*
 //La tupla resultante es [nombre,(gold,silver,bronze,fecha,fecha)]

 val olympicAthleteNuevaRDD = olympicAthletesRDD
   .reduceByKey((y, z) => (y._1 + z._1, y._2 + z._2, y._3 + z._3, if (y._4 > z._4) y._4 else z._4, if (y._5 < z._5) y._5 else z._5))

 //para llamarla el nombre (clave) es x._1 y el resto son x._2 (gold = x._2_1 ....)
 val creaObjetoRDD = olympicAthleteNuevaRDD
   .map(x => {
   new OlympicAthletes(x._1, x._2._5, x._2._4, x._2._1, x._2._2, x._2._3)
 })
   .foreach(x => println(x.getName + ", " + x.getYearFirstMedal + "," + x.getYearLastMedal + "," + x.getGoldMedals + ", " + x.getSilverMedals + "," + x.getBronzeMedals))

*/

}

