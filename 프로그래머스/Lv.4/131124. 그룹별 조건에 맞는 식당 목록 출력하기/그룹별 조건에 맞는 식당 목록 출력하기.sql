SELECT
    MEMBER_NAME,
    REVIEW_TEXT,
    DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
FROM
    MEMBER_PROFILE A
    INNER JOIN REST_REVIEW B
        ON A.MEMBER_ID = B.MEMBER_ID
WHERE
    A.MEMBER_ID = (
        SELECT 
            MEMBER_ID
        FROM
            REST_REVIEW
        GROUP BY 
            MEMBER_ID
        ORDER BY
            COUNT(MEMBER_ID) DESC
        LIMIT 1
    )
ORDER BY
    REVIEW_DATE,
    REVIEW_TEXT