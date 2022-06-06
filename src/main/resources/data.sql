INSERT INTO PRODUCT (id, name, description, only_buyers_can_review, REVIEWABLE,AVERAGE_RATING,REVIEW_COUNT)
VALUES (default, 'product1', 'Lorem ipsum dolor sit amet.', false, false,0,0);
INSERT INTO PRODUCT (id, name, description, only_buyers_can_review, REVIEWABLE,AVERAGE_RATING,REVIEW_COUNT)
VALUES (default, 'product2', 'Lorem ipsum dolor sit amet.', true, true,0,0);
INSERT INTO PRODUCT (id, name, description, only_buyers_can_review, REVIEWABLE,AVERAGE_RATING,REVIEW_COUNT)
VALUES (default, 'product3', 'Lorem ipsum dolor sit amet.', false, true,0,0);

INSERT INTO review (id, approved, comment, created_at, product_id, rating,user_id)
values (default, false, 'Lorem ipsum', CURRENT_DATE(), 3, 1,1)
