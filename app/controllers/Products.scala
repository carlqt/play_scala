package controllers

import play.api.mvc._
import models.Product
import play.api.data.Form
import play.api.data.Forms.{mapping, longNumber, nonEmptyText}

class Products extends Controller {
  private val productForm: Form[Product] = Form(
    mapping(
      "ean" -> longNumber.verifying("validation.ean.duplicate", Product.findByEan(_).isEmpty),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(Product.apply)(Product.unapply)
  )

  def list = Action { implicit request =>

    val products = Product.findAll

    Ok(views.html.products.list(products))
  }

  def show(ean: Long) = Action { implicit request =>

    Product.findByEan(ean).map(prod =>
      Ok(views.html.products.show(prod))
    ).getOrElse(NotFound)

  }

  def newProduct = Action { implicit request =>
    Ok(views.html.products.newProduct(request.flash))
  }
}
