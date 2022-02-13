const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let arr;
rl.on('line', (input) => {
  arr = input.split('');
  rl.close();
}).on('close', () => {
  console.log(solution());
})

const solution = () => {
  let ans = '';
  const s = [];
  
  for(let i = 0; i < arr.length; i++) {
    const next = arr[i];
    
    if(next === '(') {
      s.push(next);
    }
    else if(next === ')') {
      while(s.length > 0 && s[s.length - 1] !== '(') {
        ans += s.pop();
      }
      s.pop();
    }
    else if(next === '+' || next === '-') {
      while(s.length > 0 && ['*', '/', '+', '-'].includes(s[s.length - 1])) {
        ans += s.pop();
      }
      s.push(next);
    }
    else if(next === '*' || next === '/') {
      while(s.length > 0 && ['*', '/'].includes(s[s.length - 1])) {
        ans += s.pop();
      }
      s.push(next);
    }
    else {
      ans += next;
    }
  }
  
  while(s.length > 0) {
    ans += s.pop();
  }

  return ans;
}