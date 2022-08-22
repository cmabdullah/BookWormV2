

todo
cart item api

qty validation required


add product
```
curl --location --request POST 'http://localhost:8081/product/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "productName":"iphone 12",
    "productSKU":"zxc",
    "productDescription":"released on 2020",
    "productPrice":80000,
    "productWeight":200,
    "productCategory" : "phone"
}'
```

get
```
curl --location --request GET 'http://localhost:8081/product/list'
```

delete
```
curl --location --request DELETE 'http://localhost:8081/product/delete/2'
```
update

```
curl --location --request POST 'http://localhost:8081/product/update' \
--header 'Content-Type: application/json' \
--data-raw '{
    "productId":2,
    "productName":"iphone 13",
    "productSKU":"zxc",
    "productDescription":"released on 2020",
    "productPrice":80000,
    "productWeight":200,
    "productCategory" : "phone"
}'
```
order

```
curl --location --request POST 'http://localhost:8081/order/submit' \
--header 'Content-Type: application/json' \
--data-raw '{
    "shippingMethod": "redex",
    "orderTotal": 1024,
    "shippingAddress": {
        "houseNo": "H-10",
        "roadNo": "5b",
        "city": "Dhaka"
    },
    "payment": {
        "type": "amex",
        "cardName": "Abdullah",
        "cardNumber": "ac12",
        "cvc": 1022
    },
    "orderDetails": {
        "qty": 3,
        "products": [
            {
                "productId": 2,
                "productName": "iphone 13",
                "productSKU": "zxc",
                "productDescription": "released on 2020",
                "productPrice": 80000,
                "productWeight": 200,
                "productCategory": "phone"
            }
        ]
    }
}'
```


```


```