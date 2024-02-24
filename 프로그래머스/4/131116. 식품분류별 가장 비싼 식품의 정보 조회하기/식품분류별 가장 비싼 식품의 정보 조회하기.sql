SELECT
    CATEGORY
    , MAX(PRICE) MAX_PRICE
    , PRODUCT_NAME
FROM
    FOOD_PRODUCT
WHERE
    (CATEGORY, PRICE) in (
        SELECT
            CATEGORY
            , MAX(PRICE)
        FROM
            FOOD_PRODUCT
        WHERE
            CATEGORY IN ('과자', '국', '김치', '식용유')
        GROUP BY
            CATEGORY
        )
GROUP BY
    CATEGORY
ORDER BY
    MAX_PRICE DESC