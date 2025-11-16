DO
$$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'datamod') THEN
      CREATE DATABASE datamod;
END IF;
END
$$;

