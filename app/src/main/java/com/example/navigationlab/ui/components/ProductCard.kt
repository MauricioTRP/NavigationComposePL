package com.example.navigationlab.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import coil3.compose.rememberConstraintsSizeResolver
import coil3.request.ImageRequest
import com.example.navigationlab.data.Product
import com.example.navigationlab.data.local.LocalStoreDataProviderImpl

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    onClick: (Product) -> Unit
) {
    val sizeResolver = rememberConstraintsSizeResolver()
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(product.image)
            .size(sizeResolver)
            .build()
    )

    Card(
        modifier = modifier
            .clickable(onClick = { onClick(product) }),
    ) {
        Column(
            modifier = modifier.padding(start = defaultPadding, end = defaultPadding)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.size(IMAGE_SIZE)
            )
            Text(
                text = product.name,
                style = MaterialTheme.typography.labelLarge,
            )
            Text(
                text = product.description.toString(),
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}














@Preview (showBackground = true)
@Composable
private fun ProductCardPreview() {
    ProductCard(
        // TODO revisar cómo convertir esto en inyección de dependencias
        product = LocalStoreDataProviderImpl().getProducts().first(),
        onClick = { println("Clicked Card") }
    )
}

private val defaultPadding = 12.dp
private val IMAGE_SIZE = 200.dp