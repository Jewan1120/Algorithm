SELECT
    PT_NAME
    , PT_NO
    , GEND_CD
    , AGE
    , IFNULL(TLNO, 'NONE') TLNO
FROM
    PATIENT
WHERE
    AGE <= 12
    AND GEND_CD = 'W'
ORDER BY
    AGE DESC
    , PT_NAME