package net.mehvahdjukaar.complementaries.client.entity.weighter;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class WeighterAnimation {

public static final AnimationDefinition WEIGHTER_IDLE = AnimationDefinition.Builder.withLength(5.2f).looping()
.addAnimation("jaw01",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.6f, KeyframeAnimations.degreeVec(3f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(5.2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("jaw02",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(2.6f, KeyframeAnimations.degreeVec(0f, 0f, 3f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(5.2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("jaw03",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.6f, KeyframeAnimations.degreeVec(-3f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(5.2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("jaw04",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.6f, KeyframeAnimations.degreeVec(0f, 0f, -3f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(5.2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR))).build();
public static final AnimationDefinition WEIGHTER_OPEN = AnimationDefinition.Builder.withLength(2.6f)
.addAnimation("jaw01",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1.92f, KeyframeAnimations.degreeVec(55f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.6f, KeyframeAnimations.degreeVec(60f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("jaw02",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1.92f, KeyframeAnimations.degreeVec(0f, 0f, 55f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.6f, KeyframeAnimations.degreeVec(0f, 0f, 60f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("jaw03",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1.92f, KeyframeAnimations.degreeVec(-55f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.6f, KeyframeAnimations.degreeVec(-60f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("jaw04",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1.92f, KeyframeAnimations.degreeVec(0f, 0f, -55f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.6f, KeyframeAnimations.degreeVec(0f, 0f, -60f),
			AnimationChannel.Interpolations.LINEAR))).build();
public static final AnimationDefinition WEIGHTER_CLOSE = AnimationDefinition.Builder.withLength(1.56f)
.addAnimation("jaw01",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(60f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.56f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("jaw02",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 60f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.56f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("jaw03",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-60f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.56f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("jaw04",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -60f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.56f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM))).build();
}
