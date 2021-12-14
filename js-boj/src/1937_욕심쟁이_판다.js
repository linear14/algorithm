const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let n;
const arr = [];
const isVisited = [];
rl.on('line', (input) => {
  if(!n) {
    n = Number(input);
    for(let i = 0; i < n; i++) {
      isVisited.push(Array.from({ length: n }, () => false));
    }
  }
  else {
    arr.push(input.split(' ').map(i => ({ num: Number(i), moreDepth: 0 })));
    if(arr.length === n) {
      rl.close();
    }
  }
}).on('close', () => {
  console.log(sol());
})

const sol = () => {
  const arrMeta = [];
  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      arrMeta.push({ num: arr[i][j].num, x: j, y: i });
    }
  }
  arrMeta.sort((a, b) => b.num - a.num);

  const d = [[-1, 0], [1, 0], [0, -1], [0, 1]];
  arrMeta.forEach(now => {
    const [cx, cy] = [now.x, now.y];
    
    const temp = [];
    for(let i = 0; i <= 3; i++) {
      const [nx, ny] = [cx + d[i][0], cy + d[i][1]];

      if(nx >= 0 && nx < n && ny >= 0 && ny < n && !isVisited[ny][nx]) {

        // 상하좌우 값이 지금보다 작거나 같다면 
        if(arr[ny][nx].num <= now.num) {
          temp.push(-1);
        }
        // 상하좌우 값이 지금보다 크다면 이미 추가 depth를 알고있는 상황
        else {
          temp.push(arr[ny][nx].moreDepth);
        }
      }
    }

    temp.sort((a, b) => b - a);
    arr[cy][cx] = { ...arr[cy][cx], moreDepth: temp[0] + 1 };
  })

  let ans = 0;
  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
      if(ans < arr[i][j].moreDepth) {
        ans = arr[i][j].moreDepth;
      }
    }
  }
  return ans + 1;
}