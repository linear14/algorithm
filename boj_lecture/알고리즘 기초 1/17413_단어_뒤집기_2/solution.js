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

const popAllStackElements = (s) => {
  const temp = [];
  while(s.length > 0) {
    temp.push(s.pop());
  }
  return temp.join('');
}

const solution = () => {
  const ans = [];
  const s = [];
  let isPartialState = false;

  for(let i = 0; i < arr.length; i++) {
    const next = arr[i];

    if(next === '<' || (next === ' ' && !isPartialState))  {
      const reversed = popAllStackElements(s);
      ans.push(reversed);
    
      if(next === '<') {
        isPartialState = true;
      }
    }

    if(isPartialState || (next === ' ' && !isPartialState)) {
      ans.push(next)
    }
    else {
      s.push(next);
    }
    
    if(next === '>') isPartialState = false;
  }

  const remain = popAllStackElements(s);
  ans.push(remain);

  return ans.join('');
}
  