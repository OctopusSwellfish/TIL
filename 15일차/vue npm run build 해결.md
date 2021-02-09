# EC2 free tier 에서 npm run build 시 진행이 안되는 문제

* 상황 :  vue를 이용해서 프론트를 제작하고 배포하기 위해 dist파일을 만드는 중

  Building for production...Starting type checking service...
  Using 1 worker with 2048MB memory limit

  Building for production... ```

---

해결 방안 --> 512mb로 줄여주었다. 프리티어 메모리가 1기가인데 여기서 다 써버리면 평생 끝나지 않을 것 같았다.

`vue.config.js`

```
module.exports = {
  // ... CODES ...
  chainWebpack: (config) => {
    config.plugin("fork-ts-checker").tap((args) => {
      args[0].memoryLimit = 512;
      return args;
    });
  },
  // ... CODES ...
};
```

