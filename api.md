GET `/Products`

This API returns a list of products, accepts query params like pagination staff and something sorting and maybe search term for searching in products. The response will be like this:

```javascript
{
    "content": [
        {
            "id": 3,
            "name": "product",
            "provideId": 1,
            "description": "Lorem ipsum dolor sit amet.",
            "lastReviews": [
                {
                    "comment": "lorem ipsum",
                    "rating": 4
                },
                {
                    "comment": "lorem ipsum",
                    "rating": 3
                },
                {
                    "comment": "lorem ipsum",
                    "rating": 2
                }
            ],
            "reviewable": true,
            "reviewCount": 4,
            "averageRating": 2.5
        }
    ],
        "pageable": {
        ...
    }
}
```


Three values were calculated for obtaining the  `reviewable` value : The `user_id`, is product `reviewable`, and `onlyBuyersCanReview`.

First, we check if the product reviewable if it's not the `reviewable`value will be false,but if its reviewable then  we need to check if it’s `onlyBuyersCanReview` by buyers or not. 
If it’s not, anybody can write a review for this product, but of its reviewable only by buyers, we need to check the user’s previous orders and find the product in their last orders. After that, we set reviewable.

`reviewCount` and `averageRating` are in the `product` table.
they calculate when new review approve by this formula `((oldAvarage*count)+ newReview)/(count+1)`
The last reviews list is stored in Redis and updated when new review approval happens.

This API is aggregated from two services: Inquiry and Review services.

/
