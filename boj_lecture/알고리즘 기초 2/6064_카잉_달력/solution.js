const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let t;
const arr = [];
rl.on('line', (input) => {
  if(!t) t = +input;
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === t) {
      rl.close();
    }
  }
}).on('close', () => {
  const ansList = [];

  for(let i = 0; i < t; i++) {
    const [m, n, tx, ty] = arr[i];
    if(m === 1) {
      ansList.push(ty);
    }
    else if(n === 1) {
      ansList.push(tx);
    }
    else {
      let ans = 1;

      let [x, y] = [1, 1];
      while(true) {
        if(tx - x === ty - y) {
          ans += tx - x;
          break;
        }
        else {
          const [dx, dy] = [m - x, n - y];
          if(dx < dy) {
            x = 1;
            y += (dx + 1);
            ans += (dx + 1);
          }
          else if (dx > dy) {
            x += (dy + 1);
            y = 1;
            ans += (dy + 1)
          }
          else {
            ans = -1;
            break;
          }
        }
      }
      ansList.push(ans);
    }
  }
  console.log(ansList.join('\n'));
});