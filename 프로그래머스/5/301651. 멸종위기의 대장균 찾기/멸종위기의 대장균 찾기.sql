WITH RECURSIVE ECOLI_TREE AS (
    -- Non-Recursive
    SELECT
        ID
        , PARENT_ID
        , 1 GENERATION
    FROM
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL
    
    UNION ALL
    -- Recursive
    SELECT
        A.ID
        , A.PARENT_ID
        , B.GENERATION + 1
    FROM
        ECOLI_DATA A
        INNER JOIN ECOLI_TREE B
            ON A.PARENT_ID = B.ID
), 
    ECOLI_PARENT AS (
        SELECT
            DISTINCT(PARENT_ID) ID
        FROM
            ECOLI_DATA
        WHERE
            PARENT_ID IS NOT NULL
)

SELECT
    COUNT(A.ID) COUNT
    , GENERATION
FROM
    ECOLI_TREE A
    LEFT JOIN ECOLI_PARENT B
        ON A.ID = B.ID
WHERE
    B.ID IS NULL
GROUP BY
    GENERATION