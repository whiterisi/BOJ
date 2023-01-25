-- 코드를 입력하세요
SELECT FP.PRODUCT_ID, FP.PRODUCT_NAME, SUM(FO.AMOUNT)*FP.PRICE TOTAL_SALES
FROM FOOD_PRODUCT FP
LEFT JOIN FOOD_ORDER FO
ON FP.PRODUCT_ID = FO.PRODUCT_ID
WHERE FO.PRODUCE_DATE BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY PRODUCT_ID
ORDER BY TOTAL_SALES DESC, FP.PRODUCT_ID