/**
  * Author : zen.
  * Date: 2016/7/16.
  * Version :
  * Description:
  */
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
object wordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("wordCount").setMaster("local")
    val sc = new SparkContext(conf)
    val data = sc.textFile(".\\src\\main\\resources\\data.txt")
    println(data)
    data.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect().foreach(println)
  }
}
