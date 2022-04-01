const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const arr = [];
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(input.split(''));
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  let ans = 0;
  for(let i = 0; i < n; i++) {
    for(let j = 0; j < n-1; j++) {
      if(arr[i][j] !== arr[i][j+1]) {
        swap('horizontal', i, j);
        for(let k = 0; k < n; k++) {
          ans = Math.max(ans, count('vertical', k));
          ans = Math.max(ans, count('horizontal', k));
        }
        swap('horizontal', i, j);
      }
    }
  }

  for(let i = 0; i < n-1; i++) {
    for(let j = 0; j < n; j++) {
      if(arr[i][j] !== arr[i+1][j]) {
        swap('vertical', i, j);
        for(let k = 0; k < n; k++) {
          ans = Math.max(ans, count('vertical', k));
          ans = Math.max(ans, count('horizontal', k));
        }
        swap('vertical', i, j);
      }
    }
  }
  console.log(ans);
});

const swap = (dir, i, j) => {
  if(dir === 'horizontal') {
    const temp = arr[i][j];
    arr[i][j] = arr[i][j+1];
    arr[i][j+1] = temp;
  }
  else {
    const temp = arr[i][j];
    arr[i][j] = arr[i+1][j];
    arr[i+1][j] = temp;
  }
}

const count = (dir, idx) => {
  let max = 0;
  let count = 1;
  let prev = '';

  if(dir === 'vertical') {
    for(let i = 0; i < n; i++) {
      if(prev === arr[i][idx]) {
        count++;
      }
      else {
        prev = arr[i][idx];
        max = Math.max(max, count);
        count = 1;
      }
    }
    max = Math.max(max, count);
  }
  else {
    for(let i = 0; i < n; i++) {
      if(prev === arr[idx][i]) {
        count++;
      }
      else {
        prev = arr[idx][i];
        max = Math.max(max, count);
        count = 1;
      }
    }
    max = Math.max(max, count);
  }
  return max;
}