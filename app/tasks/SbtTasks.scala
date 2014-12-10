package tasks

import controllers.Application
import play.core.StaticApplication

import scala.io.Source

class Printy extends Runnable {
  def run = println("Useless Printy Task")
}

// play task

trait PlayTask extends Runnable {
  val application = new StaticApplication(new java.io.File("."))
}


class SeedDB extends PlayTask {
  def run() {
    //insertMany(CSV.from(Source.fromFile("./data/seed.csv")))
    val configSetting = application.application.configuration.getString("application.secret")
    println(configSetting + Application.foo)
  }
}
