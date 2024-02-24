SELECT
    A.ANIMAL_ID
    , A.NAME
FROM
    ANIMAL_INS A
    INNER JOIN ANIMAL_OUTS B
        ON A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY
    DATEDIFF(A.DATETIME, B.DATETIME)
LIMIT 2