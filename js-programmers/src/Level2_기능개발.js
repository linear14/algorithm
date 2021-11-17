const solution = (progresses, speeds) => {
  const ans = [];
  const length = progresses.length;
  let current = 0;

  while(current < length) {
    for(let i = current; i < length; i++) {
      progresses[i] = progresses[i] + speeds[i];
    }
    if(progresses[current] >= 100) {
      let count = 0;
      while(current < length && progresses[current] >= 100) {
        count++;
        current++;
      }
      ans.push(count);
    }
  }
  return ans;
}

const testData = [
  { progresses: [93, 30, 55], speeds: [1, 30, 5] },
  { progresses: [95, 90, 99, 99, 80, 99], speeds: [1, 1, 1, 1, 1, 1] },
]
  
testData.forEach(({ progresses, speeds }) => {
  console.log(solution(progresses, speeds));
})