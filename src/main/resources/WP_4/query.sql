SELECT name
FROM projx.person p, projx.sender s, projx.message m
WHERE p.id = s.id
AND s.id = m.sender_id
AND m.date = "2018-05-07";