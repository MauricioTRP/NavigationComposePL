package com.example.navigationlab.data.local

import com.example.navigationlab.data.Product
import javax.inject.Inject

class LocalStoreDataProviderImpl @Inject constructor () : LocalStoreDataProvider {
    private val products: List<Product> = listOf(
        Product(
            1,
            "Jacket",
            "A man cotton jacket you'd like to wear on cold days",
            "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",
            20.55
        ),
        Product(
            2,
            "Bracelet",
            "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.",
            "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",
            35.99
        ),
        Product(
            3,
            "Laptop Backpack",
            "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            15.75
        ),
        Product(
            4,
            "WD 2TB Elements Portable External Hard Drive - USB 3.0",
            "USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems; Compatibility may vary depending on user’s hardware configuration and operating system",
            "https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_.jpg",
            12.50
        ),
        Product(
            5,
            "Rain Jacket Women Windbreaker",
            "Lightweight perfet for trip or casual wear---Long sleeve with hooded, adjustable drawstring waist design. Button and zipper front closure raincoat, fully stripes Lined and The Raincoat has 2 side pockets are a good size to hold all kinds of things, it covers the hips, and the hood is generous but doesn't overdo it.Attached Cotton Lined Hood with Adjustable Drawstrings give it a real styled look.",
            "https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_-2.jpg",
            18.20
        ),
        Product(
            6,
            "Womens T Shirt",
            "95%Cotton,5%Spandex, Features: Casual, Short Sleeve, Letter Print,V-Neck,Fashion Tees, The fabric is soft and has some stretch., Occasion: Casual/Office/Beach/School/Home/Street. Season: Spring,Summer,Autumn,Winter.",
            "https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg",
            25.00
        )
    )

    override fun getProductById(productId: Int) : Product? {
        return products.firstOrNull { it.id == productId }
            ?: products.first()
    }

    override fun getProducts() : List<Product> {
        return products
    }
}
