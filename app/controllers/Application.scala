package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    //Ok(views.html.index("Your new application is ready."))
    Redirect(routes.Products.list)
  }

  def test = Action {
    Ok(views.html.test("FUCK TESTING"))
  }

  def hello(name: String) = Action {
    val myName = s"$name Tablante"
    Ok(views.html.hello(myName))
  }

}
