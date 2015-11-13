package controllers

import play.api._
import play.api.mvc._
import play.api._
import models.Product

class Products extends Controller {
  def list = Action { implicit request =>

    val products = Product.findAll

    Ok(views.html.products.list(products))
  }

  def show(ean: Long) = Action { implicit request =>

    val product = Product.findByEan(ean)

    if (product.nonEmpty){
      Ok(views.html.products.show(product))
    } else {
      NotFound
    }
  }
}
