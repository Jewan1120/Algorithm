SELECT
    HISTORY_ID,
    FLOOR(DAILY_FEE * (DATEDIFF(END_DATE, START_DATE) + 1) * (1 - (IFNULL(DISCOUNT_RATE, 0) / 100))) FEE
FROM
    (
        SELECT
            HISTORY_ID,
            DAILY_FEE,
            CAR_TYPE,
            START_DATE,
            END_DATE,
            CASE
                WHEN DATEDIFF(END_DATE, START_DATE) >= 89
                    THEN '90일 이상'
                WHEN 89 > DATEDIFF(END_DATE, START_DATE) AND DATEDIFF(END_DATE, START_DATE) >= 29
                    THEN '30일 이상'
                WHEN 29 > DATEDIFF(END_DATE, START_DATE) AND DATEDIFF(END_DATE, START_DATE) >= 6
                    THEN '7일 이상'
            END DURATION_TYPE
        FROM
            CAR_RENTAL_COMPANY_CAR A
                INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B
                    ON A.CAR_ID = B.CAR_ID
        WHERE
            CAR_TYPE = '트럭'
    ) C
    LEFT JOIN (
        SELECT
            *
        FROM
            CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        WHERE
            CAR_TYPE = '트럭'
    ) D
    ON C.DURATION_TYPE = D.DURATION_TYPE
ORDER BY
    FEE DESC,
    HISTORY_ID DESC