
## Sign Up
```
curl --location --request POST 'http://localhost:8081/public/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
"email":"abc@gmail.com",
"password":"123456"
}'
```

## Login
```
curl --location --request POST 'http://localhost:8081/public/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email":"abc@gmail.com",
    "password":"123456"
}'
```

## Profile
```
curl --location --request GET 'http://localhost:8081/auth/user/profile' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmNAZ21haWwuY29tIiwianRpIjoiMSIsImNvbnRleHQiOnsicm9sZXMiOiIiLCJ1c2VyRW1haWwiOiJhYmNAZ21haWwuY29tIiwidXNlck5hbWUiOiIiLCJ1c2VySWQiOiIxIn0sImlzcyI6IllOUkJORkpUV01ZTEgiLCJpYXQiOjE2NjExODk3MzAsImV4cCI6MTY2MjQ4NTczMH0.wbhr-OVRML9e7ORB7Mb1uK4KzwebCMFkGt71ngIlVwxhm91-OEO-PuGstM5xAKVmhfvd21YkIlFrrMLFI-oMlw' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email":"abc@gmail.com"
}'
```


todo
cart item api

qty validation required


add product
```
curl --location --request POST 'http://localhost:8081/auth/api/product/add' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmNAZ21haWwuY29tIiwianRpIjoiMSIsImNvbnRleHQiOnsicm9sZXMiOiIiLCJ1c2VyRW1haWwiOiJhYmNAZ21haWwuY29tIiwidXNlck5hbWUiOiIiLCJ1c2VySWQiOiIxIn0sImlzcyI6IllOUkJORkpUV01ZTEgiLCJpYXQiOjE2NjEyNDE4NTYsImV4cCI6MTY2MjUzNzg1Nn0.ZiA9Ao6-uoqqbx__dqco2AO0wKuP4m3oDrfl8rrFDryfxcvbMUQXhxBC7X_yq8SIHH5rcAxG5uBZ5GP1NjDrZQ' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=7C8E8A141BE22D6EA4342A1B8EA4FAE6' \
--data-raw '{
    "productName":"iphone 8",
    "productSKU":"zxc",
    "productDescription":"released on 2020",
    "productPrice":80000,
    "productWeight":200,
    "productCategory" : "phone"
}'
```

get
```
curl --location --request GET 'http://localhost:8081/auth/api/product/list'\
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmNAZ21haWwuY29tIiwianRpIjoiMSIsImNvbnRleHQiOnsicm9sZXMiOiIiLCJ1c2VyRW1haWwiOiJhYmNAZ21haWwuY29tIiwidXNlck5hbWUiOiIiLCJ1c2VySWQiOiIxIn0sImlzcyI6IllOUkJORkpUV01ZTEgiLCJpYXQiOjE2NjEyNDE4NTYsImV4cCI6MTY2MjUzNzg1Nn0.ZiA9Ao6-uoqqbx__dqco2AO0wKuP4m3oDrfl8rrFDryfxcvbMUQXhxBC7X_yq8SIHH5rcAxG5uBZ5GP1NjDrZQ' \
--header 'Cookie: JSESSIONID=7C8E8A141BE22D6EA4342A1B8EA4FAE6' \
```

delete
```
curl --location --request DELETE 'http://localhost:8081/auth/api/product/delete/2'\
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmNAZ21haWwuY29tIiwianRpIjoiMSIsImNvbnRleHQiOnsicm9sZXMiOiIiLCJ1c2VyRW1haWwiOiJhYmNAZ21haWwuY29tIiwidXNlck5hbWUiOiIiLCJ1c2VySWQiOiIxIn0sImlzcyI6IllOUkJORkpUV01ZTEgiLCJpYXQiOjE2NjEyNDE4NTYsImV4cCI6MTY2MjUzNzg1Nn0.ZiA9Ao6-uoqqbx__dqco2AO0wKuP4m3oDrfl8rrFDryfxcvbMUQXhxBC7X_yq8SIHH5rcAxG5uBZ5GP1NjDrZQ' \
--header 'Cookie: JSESSIONID=7C8E8A141BE22D6EA4342A1B8EA4FAE6' \
```
update

```
curl --location --request POST 'http://localhost:8081/auth/api/product/update' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmNAZ21haWwuY29tIiwianRpIjoiMSIsImNvbnRleHQiOnsicm9sZXMiOiIiLCJ1c2VyRW1haWwiOiJhYmNAZ21haWwuY29tIiwidXNlck5hbWUiOiIiLCJ1c2VySWQiOiIxIn0sImlzcyI6IllOUkJORkpUV01ZTEgiLCJpYXQiOjE2NjEyNDE4NTYsImV4cCI6MTY2MjUzNzg1Nn0.ZiA9Ao6-uoqqbx__dqco2AO0wKuP4m3oDrfl8rrFDryfxcvbMUQXhxBC7X_yq8SIHH5rcAxG5uBZ5GP1NjDrZQ' \
--header 'Cookie: JSESSIONID=7C8E8A141BE22D6EA4342A1B8EA4FAE6' \
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
curl --location --request POST 'http://localhost:8081/auth/api/order/submit' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmNAZ21haWwuY29tIiwianRpIjoiMSIsImNvbnRleHQiOnsicm9sZXMiOiIiLCJ1c2VyRW1haWwiOiJhYmNAZ21haWwuY29tIiwidXNlck5hbWUiOiIiLCJ1c2VySWQiOiIxIn0sImlzcyI6IllOUkJORkpUV01ZTEgiLCJpYXQiOjE2NjEyNDE4NTYsImV4cCI6MTY2MjUzNzg1Nn0.ZiA9Ao6-uoqqbx__dqco2AO0wKuP4m3oDrfl8rrFDryfxcvbMUQXhxBC7X_yq8SIHH5rcAxG5uBZ5GP1NjDrZQ' \
--header 'Cookie: JSESSIONID=7C8E8A141BE22D6EA4342A1B8EA4FAE6' \
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
    {
        "orderId":"001",
        "orderDate":"10-8-22",
        "qty":10,
        "orderDetailsList": [
            {
                "productId": 2,
                "productName": "iphone 13",
            }
            {
                "productId": 2,
                "productName": "iphone 13",
            }
        ]
    }
}'
```


```


```

http://localhost:8081/swagger-ui.html
