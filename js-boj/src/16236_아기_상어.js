const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

const ERROR = 10000;
let n;
let sharkSize = 2;
let arr = [];
let sx, sy;

rl.on('line', (input) => {
  if(!n) {
    n = Number(input);
  }
  else {
    arr.push(input.split(' ').map(i => Number(i)));
  }
  if(n === arr.length) {
    rl.close();
  }
}).on('close', () => {
  console.log(sol());
})

const sol = () => {
  setSharkPosition();
  let ans = 0;

  while(true) {
    const smallFishes = getSmallFishesPos();
    let eatCount = 0;

    
    if(smallFishes.length === 0) {
      return ans;
    }

    while(eatCount < sharkSize && smallFishes.length > 0) {
      const nowFish = getFishesData(smallFishes)[0];
      if(nowFish.distance === ERROR) {
        return ans;
      }
      ans += nowFish.distance;
      [sy, sx] = [nowFish.pos[0], nowFish.pos[1]];
      smallFishes.splice(nowFish.idx, 1);
      arr[sy][sx] = 0;

      eatCount++;
    }

    if(eatCount === sharkSize) {
      sharkSize++;
    }
  }
}

const setSharkPosition = () => {
  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      if(arr[i][j] === 9) {
        sx = j;
        sy = i;
        arr[sy][sx] = 0;
      }
    }
  }
}

// 상어보다 작은 물고기의 위치 반환 ([1,1], [2,3])
const getSmallFishesPos = () => {
  const rArr = [];
  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      if(arr[i][j] !== 0 && arr[i][j] < sharkSize) {
        rArr.push([i, j]);
      }
    }
  }
  return rArr;
}

const getFishesData = (fishesArr) => {
  return [...fishesArr.map((item, idx) => ({ pos: item, distance: getDistance(item[0], item[1]), idx }))]
    .sort((a, b) => a.distance - b.distance);
}

// 상어와 먹을 수 있는 물고기 사이의 거리 반환 (오류가 발생한다면 ERROR 반환) 
const getDistance = (fy, fx) => {
  const isVisited = Array.from({ length: n }, () => Array.from({ length: n }, () => false ));
  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];
  
  const q = [];
  isVisited[sy][sx] = true;
  q.push([sy, sx, 0]);
  
  while(q.length > 0) {
    const c = q.shift();
    for(let i = 0; i <= 3; i++) {
      const nx = c[1] + dx[i];
      const ny = c[0] + dy[i];

      if(nx >= 0 && nx < n && ny >= 0 && ny < n && !isVisited[ny][nx] && isPossible(ny, nx)) {
        if(nx === fx && ny === fy) {
          return c[2] + 1;   
        }
        
        isVisited[ny][nx] = true;
        q.push([ny, nx, c[2] + 1]);
      }
    }
  }
  return ERROR;
}

const isPossible = (ny, nx) => {
  return arr[ny][nx] <= sharkSize;
}