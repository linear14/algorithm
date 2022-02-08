const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

// solution 01
/*
let n;
const arr = [];
rl.on('line', (input) => {
  if(!n) {
    n = +input;
  }
  else {
    arr.push(input.split(' '))
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  for(let i = 0; i < n; i++) {
    const parsed = arr[i].map(item => {
      let str = '';
      for(let j = item.length - 1; j >= 0; j--) {
        str += item[j];
      }
      return str;
    });
    console.log(parsed.join(' '));
  }
})
*/

// solution 02
/*
let n;
const arr = [];
const ans = [];
rl.on('line', (input) => {
  if(!n) {
    n = +input;
  }
  else {
    arr.push(input.split(' '))
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  for(let i = 0; i < n; i++) {
    const parsed = arr[i].map(item => {
      let str = '';
      for(let j = item.length - 1; j >= 0; j--) {
        str += item[j];
      }
      return str;
    });
    ans.push(parsed.join(' '));
  }
  console.log(ans.join('\n'));
})
*/

// solution 03
let n;
const arr = [];
const ans = [];
rl.on('line', (input) => {
  if(!n) {
    n = +input;
  }
  else {
    arr.push(input.split(' '))
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  for(let i = 0; i < n; i++) {
    const parsed = arr[i].map(item => item.split('').reverse().join(''));
    ans.push(parsed.join(' '));
  }
  console.log(ans.join('\n'));
})