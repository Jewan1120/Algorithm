WITH RECURSIVE ECOLI_TREE AS (
    -- Non-Recursive
    SELECT 
        ID
        , PARENT_ID
        , 1 AS GENERATION
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
)

SELECT
    ID
FROM
    ECOLI_TREE
WHERE
    GENERATION = 3
ORDER BY 
    ID