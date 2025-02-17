SELECT
    YEAR(SALES_DATE) `YEAR`
    , MONTH(SALES_DATE) `MONTH`
    , COUNT(DISTINCT(A.USER_ID)) `PURCHASED_USERS`
    , ROUND(COUNT(DISTINCT(A.USER_ID)) / (
        SELECT
            COUNT(USER_ID)
        FROM
            USER_INFO
        WHERE
            YEAR(JOINED) = 2021
      ), 1) `PUCHASED_RATIO`
FROM
    ONLINE_SALE A
    INNER JOIN USER_INFO B
        ON A.USER_ID = B.USER_ID
WHERE
    YEAR(B.JOINED) = 2021
GROUP BY
    YEAR
    , MONTH
ORDER BY
    YEAR
    , MONTH