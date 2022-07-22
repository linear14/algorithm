const solution = (priorities, location) => {
  const remainJobs = priorities.reduce((arr, priority) => {
      arr[priority]++;
      return arr;
  } , Array(10).fill(0));
  
  const isPrinted = Array(priorities.length).fill(false);
  let currentLocation = 0;
  let ans = 0;
  
  while(true) {
      if(!isPrinted[currentLocation]) {
          const priority = priorities[currentLocation];
          const higherPriorityJobCount = remainJobs
              .slice(priority + 1)
              .reduce((pre, cur) => pre + cur, 0);
          
          if(!higherPriorityJobCount) {
              isPrinted[currentLocation] = true;
              remainJobs[priority]--;
              ans++;
              
              if(currentLocation === location) {
                  return ans;
              }
          }
      }
      currentLocation = currentLocation === priorities.length - 1 ? 0 : currentLocation + 1;
  }
};