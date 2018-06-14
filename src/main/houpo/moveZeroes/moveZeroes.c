void moveZeroes(int* nums, int numsSize) {
    int i=0, nowIndex = 0;
    for( i=0;i<numsSize;i++){
        if(nums[i] != 0){
            nums[nowIndex] = nums[i];
            nowIndex ++;
        }
    }
    for( i=nowIndex;i<numsSize;i++){
        nums[i] = 0;
    }
}
