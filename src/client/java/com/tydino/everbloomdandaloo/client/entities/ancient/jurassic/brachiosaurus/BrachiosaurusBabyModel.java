package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus;

import com.tydino.everbloomdandaloo.Utilities.MathUtility;
import com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus.BrachiosaurusRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;

public class BrachiosaurusBabyModel extends EntityModel<BrachiosaurusRenderState> {
	private final ModelPart root;
	private final ModelPart butt;
	private final ModelPart tail;
	private final ModelPart chest;
	private final ModelPart frontleftleg;
	private final ModelPart frontrightleg;
	private final ModelPart neckbase;
	private final ModelPart necktip;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart eyes;
	private final ModelPart backleftleg;
	private final ModelPart backrightleg;

	final KeyframeAnimation idle;
	final KeyframeAnimation eat;
	final KeyframeAnimation walk;
	final KeyframeAnimation sitDown;
	final KeyframeAnimation sitting;
	final KeyframeAnimation standUp;
	final KeyframeAnimation blinking;

	final KeyframeAnimation leanOver;

	public BrachiosaurusBabyModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.butt = this.root.getChild("butt");
		this.tail = this.butt.getChild("tail");
		this.chest = this.butt.getChild("chest");
		this.frontleftleg = this.chest.getChild("frontleftleg");
		this.frontrightleg = this.chest.getChild("frontrightleg");
		this.neckbase = this.chest.getChild("neckbase");
		this.necktip = this.neckbase.getChild("necktip");
		this.head = this.necktip.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.eyes = this.head.getChild("eyes");
		this.backleftleg = this.butt.getChild("backleftleg");
		this.backrightleg = this.butt.getChild("backrightleg");

		this.idle = BrachiosaurusBabyAnimations.idle.bake(root);
		this.eat = BrachiosaurusBabyAnimations.eating.bake(root);
		this.walk = BrachiosaurusBabyAnimations.walk.bake(root);
		this.sitDown = BrachiosaurusBabyAnimations.sittingdown.bake(root);
		this.sitting = BrachiosaurusBabyAnimations.sitting.bake(root);
		this.standUp = BrachiosaurusBabyAnimations.standingup.bake(root);
		this.blinking = BrachiosaurusBabyAnimations.blink.bake(root);

		this.leanOver = BrachiosaurusBabyAnimations.leandown.bake(root);
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition root = modelPartData.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition butt = root.addOrReplaceChild("butt", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 4.0F, 1.4835F, 0.0F, 0.0F));

		PartDefinition tail = butt.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(14, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition chest = butt.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 2).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition frontleftleg = chest.addOrReplaceChild("frontleftleg", CubeListBuilder.create(), PartPose.offset(3.0F, -2.0F, 1.0F));

		PartDefinition cube_r1 = frontleftleg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 4).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.0873F, -0.0873F, 0.0F));

		PartDefinition frontrightleg = chest.addOrReplaceChild("frontrightleg", CubeListBuilder.create(), PartPose.offset(-3.0F, -2.0F, 1.0F));

		PartDefinition cube_r2 = frontrightleg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 2).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.0873F, 0.0873F, 0.0F));

		PartDefinition neckbase = chest.addOrReplaceChild("neckbase", CubeListBuilder.create().texOffs(22, 17).addBox(-1.5F, -6.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition necktip = neckbase.addOrReplaceChild("necktip", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 1.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition head = necktip.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -1.0F));

		PartDefinition nose_r1 = head.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(31, 24).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -1.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition topjaw_r1 = head.addOrReplaceChild("topjaw_r1", CubeListBuilder.create().texOffs(34, 20).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.5F, 0.3491F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition cube_r3 = jaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 14).addBox(-1.0F, -1.0F, 0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(0, 6).addBox(2.05F, -0.5F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 6).addBox(-2.05F, -0.5F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -1.0F));

		PartDefinition backleftleg = butt.addOrReplaceChild("backleftleg", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r4 = backleftleg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(1, 23).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 0.0873F, -0.1745F, 0.0F));

		PartDefinition backrightleg = butt.addOrReplaceChild("backrightleg", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r5 = backrightleg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(16, 27).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0873F, 0.1745F, 0.0F));
		return LayerDefinition.create(modelData, 48, 35);
	}

	float lastBodyRot;
	float tailDragRot;

	@Override
	public void setupAnim(BrachiosaurusRenderState state) {
		super.setupAnim(state);

		if(state.blinkAnimationState.isStarted()){
			this.blinking.apply(state.blinkAnimationState, state.ageInTicks);
		}

		if(state.idleAnimationState.isStarted()){
			this.idle.apply(state.idleAnimationState, state.ageInTicks);
		}

		if(state.eatAnimationState.isStarted()){
			this.eat.apply(state.eatAnimationState, state.ageInTicks);
			this.leanOver.apply(state.leanDownAnimationState, state.ageInTicks);
		}

		if(state.sittingdownAnimationState.isStarted()){
			this.sitDown.apply(state.sittingdownAnimationState, state.ageInTicks);
		}
		if(state.sitAnimationState.isStarted()){
			this.sitting.apply(state.sitAnimationState, state.ageInTicks);
		}
		if(state.standingupAnimationState.isStarted()){
			this.standUp.apply(state.standingupAnimationState, state.ageInTicks);
		}

		this.walk.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 6f, 18f);

		//head
		this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * (float) (Math.PI / 180.0);

		//tail
		float deltaYaw = MathUtility.wrapDegrees(state.bodyRot - this.lastBodyRot);
		float targetDrag = -deltaYaw * 0.4F;
		this.tailDragRot = Math.clamp(MathUtility.lerp(0.2F, this.tailDragRot, targetDrag), -5, 5);

		this.tail.zRot = -this.tailDragRot;

		this.lastBodyRot = state.bodyRot;
	}
}