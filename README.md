# Healenium - React Demo

To run Healenium Backend
```
docker-compose -f docker-compose.yaml up -d
```

To into on the PostgreSQL
```
psql -d healenium -U healenium_user -W

Password: YDk2nmNs4s9aCP6K
```

To see results
```
select * from healenium.healing_result;
```

To run app
```
mvn install -Dtest=HelloWorld
```

# Refrences
[Healenium-Web]( https://github.com/healenium/healenium-web)
