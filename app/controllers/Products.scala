package controllers

import play.api.mvc._
import models.Product

class Products extends Controller {
  def list = Action { implicit request =>

    val products = Product.findAll

    Ok(views.html.products.list(products))
  }

  def show(ean: Long) = Action { implicit request =>

    Product.findByEan(ean).map(prod =>
      Ok(views.html.products.show(prod))
    ).getOrElse(NotFound)

  }
}
