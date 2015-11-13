package models

case class Product(ean: Long, name: String, description: String)

object Product {

  val products = Set(Product(555, "Paperclips Large", "Large Plain Pack of 1000"), Product(111L, "Greed", "Large service"), Product(2456345L, "Bomb", "A large outrageous bird that explodes"))

  def findAll = products.toList.sortBy(_.ean)

  def findByEan(ean: Long) = products.find(_.ean == ean)

}
