# Write your MySQL query statement below

SELECT * FROM cinema where mod(id,2)=1 and  description != 'boring'  order by rating desc