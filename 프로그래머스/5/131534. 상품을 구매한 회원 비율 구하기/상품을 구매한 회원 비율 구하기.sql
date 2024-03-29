SELECT
    YEAR(SALES_DATE) YEAR,
    MONTH(SALES_DATE) MONTH,
    COUNT(DISTINCT A.USER_ID) PUCHASED_USERS,
    ROUND(COUNT(DISTINCT A.USER_ID) / (
        SELECT
            COUNT(USER_ID)
        FROM
            USER_INFO
        WHERE
            YEAR(JOINED) = 2021
    ), 1) PUCHASED_RATIO
FROM
    ONLINE_SALE A
    INNER JOIN USER_INFO B
        ON A.USER_ID = B.USER_ID
WHERE
    B.JOINED LIKE '2021%'
GROUP BY
    YEAR(SALES_DATE),
    MONTH(SALES_DATE)
ORDER BY
    YEAR,
    MONTH
