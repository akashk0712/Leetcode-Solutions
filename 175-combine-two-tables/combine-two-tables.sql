# Write your MySQL query statement below
SELECT FIRSTNAME, LASTNAME, CITY, STATE
FROM PERSON P LEFT JOIN ADDRESS A
ON P.PERSONID = A.PERSONID