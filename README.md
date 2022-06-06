##assignment

The first thing that this assign ment wants from me is to make documentation for an API and you can find it [here](api.md).
Second thing was about the review application that you can find it in this repository and the postman collection [here](Assignment.postman_collection.json) and the [ERD](ERD.png)

####API documentation
This software use embedded H2 as database and redis as chasing layer.

There is 3 simple API: one of them is for getting all products, for add a review,and approve the review.
As the software runs, 3 products and one review for product number 3  are insert into the database.
after approval of the review, the review is insert into the database. you can see the affect of the review in the fetching all products API.
you cant add review for product number 1, and you can add review for product number 2 becuse you buought the product before :)     