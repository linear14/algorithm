const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

// solution 1
/*
let t;
const arr = [];
const ans = [];
rl.on('line', (input) => {
  if(!t) t = +input;
  else {
    arr.push(input);
    if(arr.length === t) rl.close();
  }
}).on('close', () => {
  arr.forEach(item => ans.push(checkVPS(item)));
  console.log(ans.join('\n'));
})

const checkVPS = (item) => {
  const s = [];
  for(let i = 0; i < item.length; i++) {
    const current = item[i];
    if(current === '(') s.push(current);
    else {
      if(s.length === 0) return 'NO';
      s.pop();
    }
  }
  return s.length === 0 ? 'YES' : 'NO';
}
*/

// solution 2
let t;
const arr = [];
const ans = [];
rl.on('line', (input) => {
  if(!t) t = +input;
  else {
    arr.push(input);
    if(arr.length === t) rl.close();
  }
}).on('close', () => {
  arr.forEach(item => ans.push(checkVPS(item)));
  console.log(ans.join('\n'));
})

const checkVPS = (item) => {
  let cnt = 0;
  for(let i = 0; i < item.length; i++) {
    const current = item[i];
    if(current === '(') cnt++;
    else {
      if(cnt === 0) return 'NO';
      cnt--;
    }
  }
  return cnt === 0 ? 'YES' : 'NO';
}