-- 코드를 입력하세요
SELECT TRUNCATE(DATE_FORMAT(DATETIME, "%T"), 6) HOUR, COUNT(*) COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR>=9 AND HOUR<20
ORDER BY HOUR