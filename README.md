
## Swagger API End points

### Auth
![Alt-Text](images/auth.png)

### Product
![Alt-Text](images/product.png)

### Order
![Alt-Text](images/order.png)

+ Change Log
  - **app** is main application
  - **coreweb** added as a dependency
  - **auth** added as a dependency
  - **email** added as a dependency
  - Docker script is moved to **app** module
  - added docker-composer
  - enhanced code quality
  - update business logic
  - curls are share on this file curlList.md
  - merged **main branch with refactor-1**
  - docker image is deployed on docker hub
  - swagger end point 
    - http://localhost:8081/swagger-ui.html
  - coreweb and auth has moved to separate repository
  - https://github.com/cmabdullah/auth.git
  - https://github.com/cmabdullah/coreweb.git

### How to run the application
> git clone https://github.com/cmabdullah/BookWormV2.git
> 
> cd BookWormV2/app
> 
> docker build -t cmabdullah21/spring-boot-docker-v14 --progress=plain .
> 
> docker-compose -f docker-compose.yml up
> 
> 

