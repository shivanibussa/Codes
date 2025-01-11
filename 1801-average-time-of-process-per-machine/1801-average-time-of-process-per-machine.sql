SElect s.machine_id,
ROUND(Avg(e.timestamp - s.timestamp),3) as processing_time from Activity s JOIN Activity e ON 
s.machine_id=e.machine_id and s.process_id=e.process_id Where s.activity_type='start' and
e.activity_type='end' group by machine_id;