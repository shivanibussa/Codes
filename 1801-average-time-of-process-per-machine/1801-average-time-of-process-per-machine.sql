-- # Write your MySQL query statement below
-- Select machine_id, AVG
-- (SELECT e.timestamp-s.timestamp from Activity s JOIN Activity e on s.machine_id=e.machine_id and s.process_id=e.process_id Where s.activity_type='start' and e.activity_type='end') as processing_time From Activity group by machine_id;


SELECT s.machine_id, 
       ROUND(AVG(e.timestamp - s.timestamp), 3) AS processing_time
FROM Activity s
JOIN Activity e
  ON s.machine_id = e.machine_id
  AND s.process_id = e.process_id
WHERE s.activity_type = 'start' 
  AND e.activity_type = 'end'
GROUP BY machine_id;

