# FoliaWorldAPI
[![](https://jitpack.io/v/treleas/folia-world-api.svg)](https://jitpack.io/#treleas/folia-world-api)

This is simple worlds creating API for Folia.

```java
final FoliaWorldApi foliaWorldApi = FoliaWorldApiProvider.unsafe();
foliaWorldApi.addWorld(
        WorldCreator.name("example")
                .type(WorldType.FLAT)
);
```
