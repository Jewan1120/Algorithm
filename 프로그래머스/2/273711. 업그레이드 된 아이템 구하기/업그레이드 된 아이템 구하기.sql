SELECT
    ITEM_ID
    , ITEM_NAME
    , RARITY
FROM
    ITEM_INFO
WHERE
    ITEM_ID IN (
        SELECT
            C.ITEM_ID
        FROM ITEM_TREE C
        INNER JOIN ITEM_INFO P
            ON C.PARENT_ITEM_ID = P.ITEM_ID
        WHERE
            RARITY = 'RARE'
    )
ORDER BY
    ITEM_ID DESC